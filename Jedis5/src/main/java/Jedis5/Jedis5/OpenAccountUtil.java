package Jedis5.Jedis5;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.BmcResult;
import com.taobao.api.domain.CheckVerCodeRequest;
import com.taobao.api.domain.OpenAccount;
import com.taobao.api.domain.OpenaccountLong;
import com.taobao.api.domain.OpenaccountObject;
import com.taobao.api.domain.OpenaccountVoid;
import com.taobao.api.domain.Userinfos;
import com.taobao.api.request.OpenAccountCreateRequest;
import com.taobao.api.request.OpenAccountDeleteRequest;
import com.taobao.api.request.OpenAccountListRequest;
import com.taobao.api.request.OpenAccountSearchRequest;
import com.taobao.api.request.OpenAccountTokenValidateRequest;
import com.taobao.api.request.OpenAccountUpdateRequest;
import com.taobao.api.request.OpenSmsCheckvercodeRequest;
import com.taobao.api.request.OpenSmsSendvercodeRequest;
import com.taobao.api.request.OpenSmsSendvercodeRequest.SendVerCodeRequest;
import com.taobao.api.request.OpenimUsersAddRequest;
import com.taobao.api.request.OpenimUsersGetRequest;
import com.taobao.api.request.OpenimUsersUpdateRequest;
import com.taobao.api.response.OpenAccountCreateResponse;
import com.taobao.api.response.OpenAccountDeleteResponse;
import com.taobao.api.response.OpenAccountListResponse;
import com.taobao.api.response.OpenAccountSearchResponse;
import com.taobao.api.response.OpenAccountTokenValidateResponse;
import com.taobao.api.response.OpenAccountUpdateResponse;
import com.taobao.api.response.OpenSmsCheckvercodeResponse;
import com.taobao.api.response.OpenSmsSendvercodeResponse;
import com.taobao.api.response.OpenimUsersAddResponse;
import com.taobao.api.response.OpenimUsersGetResponse;
import com.taobao.api.response.OpenimUsersUpdateResponse;

/**
 * 获取阿里百川相关消息
 * 
 * @author Administrator
 *
 */
public class OpenAccountUtil {
	private static Log logger = LogFactory.getLog(OpenAccountUtil.class);
	private static String ACCESS_KEY = "ALIBAICHUAN_ACCESS_KEY";
	private static String ACCESS_KEY_SECRET = "ALIBAICHUAN_ACCESS_KEY_SECRET";
	private static String BAICHUAN_URL = "ALIBAICHUAN_URL";
	private static String accessKey;
	private static String accessKeySecret;
	private static String baichuanUrl;
	private static String qq_app_id;

	static {
		baichuanUrl = "http://gw.api.taobao.com/router/rest";
		accessKey = "23238460";
		accessKeySecret = "54d40f7cc12bb3f26354321748b27213";
		qq_app_id = "1104875970";
		// taobaoClient=new
		// DefaultTaobaoClient("http://gw.api.taobao.com/router/rest",
		// "23238460", "54d40f7cc12bb3f26354321748b27213");
	}

	/**
	 * 根据云账号id获得云账号信息
	 */
	public static OpenAccount getOpenAccountInfo(String accountId) {
		TaobaoClient taobaoClient = new DefaultTaobaoClient(baichuanUrl,
				accessKey, accessKeySecret);
		OpenAccountSearchRequest req = new OpenAccountSearchRequest();
		req.setQuery("q=id:" + accountId);
		OpenAccountSearchResponse response = null;
		try {
			response = taobaoClient.execute(req);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (response.getData().getSuccessful()) {
			return response.getData().getDatas().get(0);
		} else {
			return null;
		}
	}

	/**
	 * 通过查询条件获取openAccount
	 * @param infoType
	 * @param info
	 * @return
	 */
	public static OpenAccount getOpenAccountInfoByInfo(String infoType,
			String info) {
		TaobaoClient taobaoClient = new DefaultTaobaoClient(baichuanUrl,
				accessKey, accessKeySecret);
		OpenAccountSearchRequest req = new OpenAccountSearchRequest();
		req.setQuery("q=" + infoType + ":" + info);
		OpenAccountSearchResponse response = null;
		try {
			response = taobaoClient.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		if (response.getData().getSuccessful()) {
			if (response.getData().getDatas() != null
					&& response.getData().getDatas().size() > 0) {
				return response.getData().getDatas().get(0);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 修改用户信息
	 * 
	 * @param openAccount
	 * @return
	 */
	public static OpenaccountVoid updateOpenAccont(OpenAccount openAccount) {
		TaobaoClient taobaoClient = new DefaultTaobaoClient(baichuanUrl,
				accessKey, accessKeySecret);
		List<com.taobao.api.domain.OpenAccount> list116729 = new ArrayList<com.taobao.api.domain.OpenAccount>();
		list116729.add(openAccount);
		OpenAccountUpdateRequest req = new OpenAccountUpdateRequest();
		req.setParamList(list116729);
		OpenaccountVoid openaccountVoid = new OpenaccountVoid();
		try {
			OpenAccountUpdateResponse rsp = taobaoClient.execute(req);
			openaccountVoid = rsp.getDatas().get(0);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return openaccountVoid;
	}

	/**
	 * 删除account
	 * 
	 * @param openAccountId
	 * @return
	 */
	public static OpenaccountVoid dropOpenAccount(String openAccountId) {
		TaobaoClient taobaoClient = new DefaultTaobaoClient(baichuanUrl,
				accessKey, accessKeySecret);
		OpenAccountDeleteRequest dreq = new OpenAccountDeleteRequest();
		dreq.setOpenAccountIds(openAccountId);
		try {
			OpenAccountDeleteResponse dres = taobaoClient.execute(dreq);
			return dres.getDatas().get(0);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 经过云账号token验证获取用户信息
	 */
	public static OpenAccount validateToken(String token) {
		TaobaoClient taobaoClient = new DefaultTaobaoClient(baichuanUrl,
				accessKey, accessKeySecret);
		OpenAccountTokenValidateRequest req = new OpenAccountTokenValidateRequest();
		req.setParamToken(token);
		OpenAccountTokenValidateResponse response = null;
		try {
			response = taobaoClient.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		if (response != null && response.getData().getSuccessful()) {
			return response.getData().getData().getExt().getOpenAccount();
		} else {
			logger.error("Error validate token,error: " + response.getMsg());
			return null;
		}
	}

	/**
	 * 发送短信验证码
	 * 
	 * @param phone
	 */
	public static String sendVerCode(String phone) {
		TaobaoClient taobaoClient = new DefaultTaobaoClient(baichuanUrl,
				accessKey, accessKeySecret);
		OpenSmsSendvercodeRequest req = new OpenSmsSendvercodeRequest();
		SendVerCodeRequest obj116864 = new SendVerCodeRequest();
		obj116864.setExpireTime(300L);
		obj116864.setTemplateId(13L);
		obj116864.setSignatureId(298L);
//		obj116864.setAppKey(accessKey);
		obj116864.setMobile(phone);
		req.setSendVerCodeRequest(obj116864);
		try {
			OpenSmsSendvercodeResponse rsp = taobaoClient.execute(req);
			return rsp.getBody();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 验证码验证
	 * 
	 * @param phone
	 * @param verCode
	 * @return
	 */
	public static BmcResult checkVerCode(String phone, String verCode) {
		TaobaoClient taobaoClient = new DefaultTaobaoClient(baichuanUrl,
				accessKey, accessKeySecret);
		OpenSmsCheckvercodeRequest req = new OpenSmsCheckvercodeRequest();
		CheckVerCodeRequest obj116871 = new CheckVerCodeRequest();
		obj116871.setCheckFailLimit(5L);
		obj116871.setCheckSuccessLimit(3L);
		obj116871.setVerCode(verCode);
		obj116871.setMobile(phone);
		req.setCheckVerCodeRequest(obj116871);
		try {
			OpenSmsCheckvercodeResponse rsp = taobaoClient.execute(req);
			return rsp.getResult();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 插入用户
	 */
	public static OpenaccountLong insertUser(OpenAccount openAccount) {
		TaobaoClient taobaoClient = new DefaultTaobaoClient(baichuanUrl,
				accessKey, accessKeySecret);
		OpenAccountCreateRequest req = new OpenAccountCreateRequest();
		List<OpenAccount> paramList = new ArrayList<OpenAccount>();
		paramList.add(openAccount);
		req.setParamList(paramList);
		try {
			OpenAccountCreateResponse response = taobaoClient.execute(req);
			return response.getDatas().get(0);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 修改IM信息
	 * 
	 * @param user
	 * @return
	 */
	public static String updateIMUserInfo(Userinfos user) {
		TaobaoClient taobaoClient = new DefaultTaobaoClient(baichuanUrl,
				accessKey, accessKeySecret);
		OpenimUsersUpdateRequest req = new OpenimUsersUpdateRequest();
		List<Userinfos> users = new ArrayList<Userinfos>();
		users.add(user);
		req.setUserinfos(users);
		try {
			OpenimUsersUpdateResponse res = taobaoClient.execute(req);
			if (res.getUidSucc().size() > 0) {
				return res.getUidSucc().get(0);
			}

		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加IM账号
	 * 
	 * @param user
	 * @return
	 */
	public static String addIMUserInfo(Userinfos user) {
		TaobaoClient taobaoClient = new DefaultTaobaoClient(baichuanUrl,
				accessKey, accessKeySecret);
		OpenimUsersAddRequest req = new OpenimUsersAddRequest();
		List<Userinfos> users = new ArrayList<Userinfos>();
		users.add(user);
		req.setUserinfos(users);
		try {
			OpenimUsersAddResponse res = taobaoClient.execute(req);
			if (res.getUidSucc().size() > 0) {
				return res.getUidSucc().get(0);
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取IM账号
	 * 
	 * @param user
	 * @return
	 */
	public static Userinfos getIMUserInfo(String uid) {
		TaobaoClient taobaoClient = new DefaultTaobaoClient(baichuanUrl,
				accessKey, accessKeySecret);
		OpenimUsersGetRequest req = new OpenimUsersGetRequest();
		req.setUserids(uid);
		try {
			OpenimUsersGetResponse res = taobaoClient.execute(req);
			if (StringUtil.isEmpty(res.getErrorCode()) && res.getUserinfos() != null) {
				return res.getUserinfos().get(0);
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * 根据微信token和openid获取信息
	 */
	public static JSONObject getWxInfo(String token, String openid) {
		if (StringUtil.isEmpty(openid)) {
			return null;
		}
		try {
			String resp = WebUtil
					.doGet("https://api.weixin.qq.com/sns/userinfo?access_token="
							+ token + "&openid=" + openid);
			if (resp != null) {
				return JSON.parseObject(resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据微博token和openid获取信息
	 */
	public static JSONObject getWeiBoInfo(String token, String openid) {
		if (StringUtil.isEmpty(openid)) {
			return null;
		}
		try {
			String resp = WebUtil
					.doGet("https://api.weibo.com/2/users/show.json?access_token="
							+ token + "&uid=" + openid);
			if (resp != null) {
				return JSON.parseObject(resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 根据qq token和openid获取信息
	 */
	public static JSONObject getQqInfo(String token, String openid) {
		if (StringUtil.isEmpty(openid)) {
			return null;
		}
		try {
			String resp = WebUtil
					.doGet("https://graph.qq.com/user/get_user_info?access_token="
							+ token + "&oauth_consumer_key="+qq_app_id+"&openid=" + openid);
			if (resp != null) {
				return JSON.parseObject(resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
//		OpenAccount openAccount = getOpenAccountInfoByInfo("email", "279714679@qq.com");
		TaobaoClient taobaoClient = new DefaultTaobaoClient(baichuanUrl,
				accessKey, accessKeySecret);
		OpenAccountListRequest req = new OpenAccountListRequest();
		OpenAccountListResponse response = null;
		try {
			response = taobaoClient.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		System.out.println(response.getDatas());
		List<OpenaccountObject> list = response.getDatas();
		System.out.println(list.size());
		for(OpenaccountObject account : list){
			System.out.println(account.getData().getId());
		}
//		OpenAccount openAccount2 = getOpenAccountInfo("4398047076281");
//		openAccount.setMobile(null);
//		OpenaccountVoid openaccountVoid = updateOpenAccont(openAccount);
//		System.out.println(openaccountVoid.getMessage()+ "  "+openaccountVoid.getSuccessful()+"  "+openaccountVoid.getCode());
//		dropOpenAccount("4398047559444");
	}
}
