package goit.dev.hw5.controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class DefaultEntityController<T> implements GetEntityController {
    private String entityString;
    @Override
    public T getEntity() {

        if (entityString == null) {
            return null;
        }
        Type type = new TypeToken<T>() { }.getType();
        try {
            return new Gson().fromJson(entityString, type);
        } catch (JsonSyntaxException jse) {
            return null;
        }
    }

    public String getEntityAsString () {
        return entityString;
    }

    protected void setEntityString(String s) {
        entityString = s;
    }
}
