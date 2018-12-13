package com.example.latte.ec.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author Marko
 * @date 2018/12/12
 * 我们可以在gradle中对greendao的generator生成文件进行配置
 * greendao {
 * schemaVersion 1  //版本
 * daoPackage '生成文件包名' // 一般为app包名+生成文件的文件夹名
 * targetGenDir 'src/main/java' //生成文件路径
 * }
 * 但是一般不建议直接把greendao的相关配置暴露出来，看不见的才是最安全的
 * 不进行配置dao文件会自动生成在build目录下
 * <p>
 * <p>
 * <p>
 * (1)@Entity 实体标识
 *      @nameInDb 在数据库中的名字，如不写则为实体中类名
 *      @indexes 索引
 *      @createInDb 是否创建表，默认为true,false时不创建
 *      @schema 指定架构名称为实体
 *      @active 无论是更新生成都刷新
 * （2）@Id 每条数据对应的位置，必写项
 * （3）@Property(nameInDb = "") 表示该属性将作为表的一个字段,
 *      其中nameInDb属性值是在数据库中对应的字段名称,可以自定义字段名,例如可以定一个跟实体对象字段不一样的字段名
 * （4）@NotNull 不为null
 * （5）@Unique 唯一约束   该属性值必须在数据库中是唯一值
 * （6）@ToMany 一对多
 * （7）@OrderBy 排序
 * （8）@ToOne 一对一 关系表
 * （9）@Transient 不保存于数据库
 * （10）@generated 由greendao产生的构造函数或方法
 * ---------------------
 * 作者：Seven丶Echo
 * 来源：CSDN
 * 原文：https://blog.csdn.net/qq_38520096/article/details/78833801
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */

@Entity(nameInDb = "user_profile")
public class UserProfile {
    @Id
    private long userId = 0;
    private String name = null;
    private String avatar = null;
    private String gender = null;
    private String address = null;

    @Generated(hash = 1202698052)
    public UserProfile(long userId, String name, String avatar, String gender,
                       String address) {
        this.userId = userId;
        this.name = name;
        this.avatar = avatar;
        this.gender = gender;
        this.address = address;
    }

    @Generated(hash = 968487393)
    public UserProfile() {
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
