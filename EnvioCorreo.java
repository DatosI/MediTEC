package com.example.yenma.clienteapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase para enviar el correo del cliente al servidor por medio de JSON
 @author yenma
 @version 11/05/2017/1
 *
 */

public class EnvioCorreo {
    private String correo;
    public EnvioCorreo (String pcorreo){
        this.correo = pcorreo;
    }
    public String getCorreo(){
        return correo;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public String toJson(){
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("e-mail", getCorreo());
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
