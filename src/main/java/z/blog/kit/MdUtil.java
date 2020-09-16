package z.blog.kit;

import lombok.extern.slf4j.Slf4j;
import org.commonmark.Extension;
import org.commonmark.ext.front.matter.YamlFrontMatterExtension;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.NodeRenderer;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.html.HtmlWriter;
import spark.utils.StringUtils;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class MdUtil {

    //插件列表
    private static final List<Extension> extensions = Arrays.asList(
            TablesExtension.create(),
            StrikethroughExtension.create(),
            HeadingAnchorExtension.create(),
            YamlFrontMatterExtension.create()
    );

    private MdUtil() {
    }

    /**
     * markdown转换为html
     */
    public static String md2Html(String markdown) {
        if (StringUtils.isBlank(markdown)) {
            return "";
        }
        //加载驱动
        Parser parser = Parser.builder().extensions(extensions).build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder()
                //.nodeRendererFactory(IndentedCodeBlockNodeRenderer::new)
                .attributeProviderFactory(context -> (node, tagName, attribute) -> {
                    if (node instanceof Link) {
                        attribute.put("target", "_blank");
                    }
                    if (node instanceof Image) {
                        attribute.put("title", attribute.get("alt"));
                    }
                })
                .extensions(extensions)
                .build();
        //md2html
        String content = renderer.render(document);
        //转换emoji表情
        //content = EmojiParser.parseToUnicode(content);

        // 支持网易云音乐输出
        /*if (TaleConst.BCONF.getBoolean(ENV_SUPPORT_163_MUSIC, true) && content.contains(MP3_PREFIX)) {
            content = content.replaceAll(MUSIC_REG_PATTERN, MUSIC_IFRAME);
        }*/
        // 支持gist代码输出
        /*if (TaleConst.BCONF.getBoolean(ENV_SUPPORT_GIST, true) && content.contains(GIST_PREFIX_URL)) {
            content = content.replaceAll(GIST_REG_PATTERN, GIST_REPLATE_PATTERN);
        }*/
        return content;
    }
}

@Slf4j
class IndentedCodeBlockNodeRenderer implements NodeRenderer {
    private final HtmlWriter html;

    public IndentedCodeBlockNodeRenderer(HtmlNodeRendererContext context) {
        this.html = context.getWriter();
    }

    @Override
    public Set<Class<? extends Node>> getNodeTypes() {
        return Collections.singleton(FencedCodeBlock.class);
    }

    @Override
    public void render(Node node) {
        FencedCodeBlock codeBlock = (FencedCodeBlock) node;

        Map<String, String> attr = new HashMap<>();
        if (codeBlock.getInfo() != null && codeBlock.getInfo().length() > 0) {
            attr.put("class", "language-" + codeBlock.getInfo());
        }

        html.line();
        html.tag("pre");
        html.tag("code", attr);

        String content = codeBlock.getLiteral();
        BufferedReader reader = new BufferedReader(new StringReader(content));
        StringJoiner finalCode = new StringJoiner("\n");
        List<String> list = reader.lines().collect(Collectors.toList());
        for (int a = 0; a < list.size(); a++) {
            finalCode.add((a + 1) + " " + list.get(a));
        }
        html.text(finalCode.toString());

        html.tag("/code");
        html.tag("/pre");
    }
}