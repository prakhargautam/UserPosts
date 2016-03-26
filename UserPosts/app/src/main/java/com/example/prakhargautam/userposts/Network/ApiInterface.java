package com.example.prakhargautam.userposts.Network;

import com.example.prakhargautam.userposts.models.Comments;
import com.example.prakhargautam.userposts.models.Post;
import com.example.prakhargautam.userposts.models.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by prakhargautam on 23/03/16.
 */
public interface ApiInterface {

    @GET("users")
    Call<ArrayList<User>> getUser();

    @GET("posts")
    Call<ArrayList<Post>> getPosts(@Query("userId") int userId);

    @GET("comments")
    Call<ArrayList<Comments>> getComments(@Query("postId") int postId);

    @POST("posts")
    Call<User> createUser(@Body User user);
//
//    @POST("posts")
//    Call<Post> createPost(@Body Post post);
//
//    @POST("posts")
//    Call<Comments> createComment(@Body Comments comment);
}
