/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Admiz
 */
public class Constants {
        public static String GOOGLE_CLIENT_ID = "141214771854-33rnar1snvr2bv4b32bmqsafl4aopssn.apps.googleusercontent.com";

	public static String GOOGLE_CLIENT_SECRET = "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";

	public static String GOOGLE_REDIRECT_URI = "http://localhost:8084/SWP-Thrift-Shop/LoginGoogleHandler";
        
        public static String GOOGLE_REDIRECT_URIV2 = "http://localhost:8084/SWP-Thrift-Shop/RegisterGoogleController";

	public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";

	public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";

	public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
