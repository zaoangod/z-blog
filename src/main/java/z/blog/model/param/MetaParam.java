package z.blog.model.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import z.blog.model.entity.Meta;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class MetaParam extends Meta {
    private Integer pageNum;
    private Integer pageSize;
}