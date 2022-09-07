package Core.Data;

import Core.Util.Constant;
import com.google.common.collect.Lists;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class Users  {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private List<User> users = Lists.newArrayList();
    String environment= Constant.defaultEnv;

    public Users() {
        load();
    }


    private void load() {
        String file;

        file = "conf" + File.separator + getEnvironment().toLowerCase() + File.separator + "user.json";

        try {
            Type userList = new TypeToken<List<User>>() {
            }.getType();
            this.users = new GsonBuilder().create().fromJson(new FileReader(file), userList);
        } catch (FileNotFoundException e) {
            log.debug("GsonBuilder failed",e);
        }
    }

    public String getEnvironment(){
        if(System.getProperty("environment")!=null)
        {
            environment=System.getProperty("environment");
            return environment;
        }else
            return environment;
    }


    public User findUser(String user) {
        return users.stream().filter(s -> s.getUser().equalsIgnoreCase(user)).findAny().get();
    }
}
