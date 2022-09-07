package Core.Data;


import Core.Util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestData {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private User userUnderTest;
    private Users users;



    public TestData(){
        userUnderTest=new User();
        users=new Users();
    }


    public void addUser() {

        if (!Constant.userUnderTest.contains("without")) {
            userUnderTest = users.findUser(Constant.userUnderTest);
            log.info("Logged in as a Registered User :" + userUnderTest );
        }else
        {
            log.info("Guest User");
        }
    }


    public String getUserInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("username : " + userUnderTest.getFirstname() + " " + userUnderTest.getLastname());
        sb.append("\nemail : " + userUnderTest.getEmail());
        sb.append("\ncountry : " + userUnderTest.getCountry());
        sb.append("\ntype : " + userUnderTest.getType());
        sb.append("\n--------------\n");
        return sb.toString();
    }

    public User getUser() {
        return userUnderTest;
    }
}
