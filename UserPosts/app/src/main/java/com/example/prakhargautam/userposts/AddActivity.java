package com.example.prakhargautam.userposts;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.prakhargautam.userposts.Fragments.AddCommentFragment;
import com.example.prakhargautam.userposts.Fragments.AddPostFragment;
import com.example.prakhargautam.userposts.Fragments.AddUserFragment;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        FragmentManager fragmentManager= getFragmentManager();
        Intent i= getIntent();
        String s= i.getStringExtra("calling_activity");
        if(s.equals("main")){
            AddUserFragment addUserFragment= new AddUserFragment();
            fragmentManager.beginTransaction().add(R.id.container,addUserFragment,"user_fragment").commit();
        }
        else if(s.equals("post")){
            AddPostFragment addPostFragment=new AddPostFragment();
            fragmentManager.beginTransaction().add(R.id.container,addPostFragment,"post_fragment").commit();
        }
        else if(s.equals("comment")){
            AddCommentFragment addCommentFragment= new AddCommentFragment();
            fragmentManager.beginTransaction().add(R.id.container,addCommentFragment,"comment_fragment").commit();
        }
    }
}
