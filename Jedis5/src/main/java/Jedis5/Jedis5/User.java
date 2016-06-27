package Jedis5.Jedis5;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 核心用户表
 */
public class User implements Serializable{
	private static final long serialVersionUID = 3823793693019443578L;

	private String uid; // 用户的主键ID
	private String openAccountId; // 用户百川字段
	private Long oauthPlateform; // 第三方平台（ 电话 = 1;WEIXIN = 2;WEIBO = 3;QQ = 4;）
	private String oauthOpenid; // 第三方id
	private String username; // 用户名
	private String password; // 密码
	private Integer pwdEncyption; // 加密算法类型：1、代表单纯MD5，2：代表单一Salt的MD5，3、代表根据记录不同后的MD5
	private String salt; // 密码盐值
	private String phone; //电话
	private String email; //email
	private String realName; //运营名称
	private String nick; // 昵称
	private String repeatNick; // 重复的昵称
	private String avatar; // 头像（地址）
	private Integer gender; // 性别 性别，0保密，1男，2女
	private Timestamp birthday; // 出生日期
	private String hobby; // 兴趣爱好
	private String motto; // 个性签名
	private Integer roleId; // 用户角色1管理员0或不填为普通用户
	private Integer stat; // 用户状态，1启用，2禁用
	private String registerIp; // 注册IP
	private String registerCity; // 注册城市
	private Timestamp lastLoginTime; // 上次登录时间
	private Timestamp registerTime; // 注册时间
	private Timestamp forbidEndtime;// 封禁截止时间
	private String pictures;// 照片集（“，”隔开）
	private String backgroundPicture;// 用户照片集背后的背景图
	private String tags;// 添加的标签
	private Integer positionNo;// 职业编号
	private Integer marriageStat;// 情感状态：0为保密，1为单身，2为恋爱，3为已婚，4为同性
	private String remark;// 马甲号备注
	
	public User() {
		super();
		this.marriageStat = 0;
		this.username = "";
		this.phone = "";
		this.nick = "";
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getOpenAccountId() {
		return openAccountId;
	}

	public void setOpenAccountId(String openAccountId) {
		this.openAccountId = openAccountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPwdEncyption() {
		return pwdEncyption;
	}

	public void setPwdEncyption(Integer pwdEncyption) {
		this.pwdEncyption = pwdEncyption;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getRepeatNick() {
		return repeatNick;
	}

	public void setRepeatNick(String repeatNick) {
		this.repeatNick = repeatNick;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getStat() {
		return stat;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}

	public String getRegisterIp() {
		return registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public String getRegisterCity() {
		return registerCity;
	}

	public void setRegisterCity(String registerCity) {
		this.registerCity = registerCity;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Timestamp getForbidEndtime() {
		return forbidEndtime;
	}

	public void setForbidEndtime(Timestamp forbidEndtime) {
		this.forbidEndtime = forbidEndtime;
	}

	public Long getOauthPlateform() {
		return oauthPlateform;
	}

	public void setOauthPlateform(Long oauthPlateform) {
		this.oauthPlateform = oauthPlateform;
	}

	public String getOauthOpenid() {
		return oauthOpenid;
	}

	public void setOauthOpenid(String oauthOpenid) {
		this.oauthOpenid = oauthOpenid;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public String getBackgroundPicture() {
		return backgroundPicture;
	}

	public void setBackgroundPicture(String backgroundPicture) {
		this.backgroundPicture = backgroundPicture;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getPositionNo() {
		return positionNo;
	}

	public void setPositionNo(Integer positionNo) {
		this.positionNo = positionNo;
	}

	public Integer getMarriageStat() {
		return marriageStat;
	}

	public void setMarriageStat(Integer marriageStat) {
		this.marriageStat = marriageStat;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
