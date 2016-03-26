package com.example.prakhargautam.userposts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.prakhargautam.userposts.Fragments.CommentFragment;
import com.example.prakhargautam.userposts.Fragments.PostFragment;
import com.example.prakhargautam.userposts.Fragments.UserFragment;
import com.example.prakhargautam.userposts.Network.ApiClient;
import com.example.prakhargautam.userposts.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements UserFragment.onPassId, PostFragment.onPassPostId{

    static final int REQUEST_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Users");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.create_user){
            Intent i= new Intent();
            i.putExtra("calling_activity","main");
            i.setClass(MainActivity.this, AddActivity.class);
            startActivityForResult(i, REQUEST_CODE);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        User user= (User) data.getSerializableExtra("new_user");
        UserFragment userFragment=(UserFragment) getFragmentManager().findFragmentById(R.id.user_fragment);
        userFragment.createNewUser(user);
    }

    @Override
    public void onPass(int id) {
        View v= findViewById(R.id.dummy);
        if(v!=null)
        {
            PostFragment pf=(PostFragment) getFragmentManager().findFragmentById(R.id.post_fragment);
            pf.CreatePostList(id);
        }
        else {
            Intent i = new Intent();
            i.putExtra("userId", id);
            i.setClass(MainActivity.this, PostActivity.class);
            startActivity(i);
        }
    }

    @Override
    public void onPassPostId(int id) {
        CommentFragment cf=(CommentFragment) getFragmentManager().findFragmentById(R.id.comment_fragment);
        cf.CreateCommentList(id);
    }
}
