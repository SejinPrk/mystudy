package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Assignment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.units.qual.A;

public class DaoProxyGenerator {

  private DataInputStream in;
  private DataOutputStream out;
  private Gson gson;

  public DaoProxyGenerator(DataInputStream in, DataOutputStream out) {
    this.in = in;
    this.out = out;
    gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
  }

  public <T> T create(Class<T> clazz, String dataName) {
    return (T) Proxy.newProxyInstance(
        DaoProxyGenerator.class.getClassLoader(),
        new Class<?>[]{clazz},
        (proxy, method, args) -> {
          try {
            out.writeUTF(dataName);
            out.writeUTF(method.getName());
            if (args == null) {
              out.writeUTF("");
            } else {
              out.writeUTF(gson.toJson(args[0]));
            }

            String statusCode = in.readUTF();
            String entity = in.readUTF();

            if (!statusCode.equals("200")) {
              throw new Exception(entity);
            }

            Type returnType = method.getGenericReturnType();

            if (returnType == void.class) {
              return null;
            } else {
              return gson.fromJson(entity, returnType);
            }

          } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException(e);
          }
        }
    );
  }
}
