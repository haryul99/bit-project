package com.example.nailmanna;

import java.io.Serializable;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface UserService {
    //자원의 정보를 정의할 인터페이스 구현 Http Method(GET, POST, PUT, DELETE)

    @POST("accounts/login/")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);


    @POST("accounts/register/")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);

    //텍스트와 이미지는 한 번에 보낼 수 없기에 @part로 나눠서 전송
    @Multipart
    @POST("upload/")
    Call<AddCustomerRes> addCustomer(@Header("Authorization") String token,
                                     @Part MultipartBody.Part my_photo,
                                     @Part ("my_photo_title")RequestBody my_photo_title);

    // 내가 좋아요 한 파일
    @GET("mylike/")
    Call<List<AddCustomerRes>> LikePhoto (@Header("Authorization") String token);

    // 내가 올린 파일
    @GET("upload/")
    Call<List<AddCustomerRes>> MyUpload (@Header("Authorization") String token);

    // 전체
    @GET("all/")
    Call<List<AddCustomerRes>> PhotoAll(@Header("Authorization") String token);

    // 좋아요
    @GET("like/{my_photo_title}/")
    Call<AddCustomerRes> PhotoLike (@Header("Authorization") String token,
                                    @Path ("my_photo_title") String my_photo_title);

    // 내가 올린 사진 수정
    @PUT("update/{my_photo_title}/")
    Call<AddCustomerRes> PhotoUpdate (@Header("Authorization") String token,
                                      @Path ("my_photo_title") String my_photo_titl,
                                      @Part ("my_photo_title") String my_photo_title);


    // 사진 삭제
    @Multipart
    @HTTP(method = "DELETE", path = "upload/", hasBody = true)
    Call<AddCustomerRes> PhotoDel(@Header("Authorization") String token,
                                  @Part ("my_photo_title")RequestBody my_photo_title);
}

