package claw.scctcn;


import lombok.Getter;
import lombok.Setter;

/**
 * @author yongqiangyao
 * 获取数据
 */
@Getter
@Setter
public class Scctcn {
    private String dbId;
    private String containerOwner;
    private String opType;
    private String opTime;
    private String columnName;
    private String oldValue;
    private String newValue;
    private String remark;

}
