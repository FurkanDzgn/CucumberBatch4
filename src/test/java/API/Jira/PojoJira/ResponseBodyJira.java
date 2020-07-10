package API.Jira.PojoJira;

import java.util.Map;

public class ResponseBodyJira {

    private static Session session;
    private static LoginInfo loginInfo;

//    private Map<String,Object> session;  // second way
//    private Map<String,Object> loginInfo;


    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }
}
