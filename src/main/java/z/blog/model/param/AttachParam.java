package z.blog.model.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import z.blog.model.entity.Attach;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class AttachParam extends Attach {
    private Integer pageNum;
    private Integer pageSize;

    public AttachParam() {
    }

    public AttachParam(Attach param) {
        setAid(param.getAid());
        setName(param.getName());
        setType(param.getType());
        setKey(param.getKey());
        setCreateTime(param.getCreateTime());
        setUrl(param.getUrl());
        setStatus(param.getStatus());
    }
}