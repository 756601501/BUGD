package Jedis5.Jedis5;

import java.sql.Timestamp;

/**
 * 帖子
 */
public class Post {
	private String pid; // 主ID
	private String uid; // 用户ID
	private String title; // 标题
	private String content; // 内容
	private String pictures; //图片逗号隔开
	private Integer gid;//圈子ID
	private Timestamp lastModifyTime; // 上次修改时间
	private Timestamp createTime; // 发贴时间
	private Integer visitNum; //观看
	private String headId; //是否已经推到头条1是，0否
	private Integer stat; // 状态 0未审核，1审核通过，2审核未通过,3下架,4被举报,5举报下架
	private Integer isDelete = 0;
	private Integer isRobot = 0;
	private Integer shareNum; //分享次数
	private Timestamp topTime;//顶置的时间，用来判断是否顶置以及排序
	//最后一次计算帖子阅读或者评论分享所得分值的时间点
	private Timestamp lastCountTime; 

	public Post() {
		super();
		this.isDelete = 0;
		this.isRobot = 0;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Timestamp getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}

	public String getHeadId() {
		return headId;
	}

	public void setHeadId(String headId) {
		this.headId = headId;
	}

	public Integer getStat() {
		return stat;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getIsRobot() {
		return isRobot;
	}

	public void setIsRobot(Integer isRobot) {
		this.isRobot = isRobot;
	}

	public Integer getShareNum() {
		return shareNum;
	}

	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}

	public Timestamp getTopTime() {
		return topTime;
	}

	public void setTopTime(Timestamp topTime) {
		this.topTime = topTime;
	}

	public Timestamp getLastCountTime() {
		return lastCountTime;
	}

	public void setLastCountTime(Timestamp lastCountTime) {
		this.lastCountTime = lastCountTime;
	}

}
