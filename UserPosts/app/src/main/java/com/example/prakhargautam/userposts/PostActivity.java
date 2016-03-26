package com.example.prakhargautam.userposts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.prakhargautam.userposts.Fragments.CommentFragment;
import com.example.prakhargautam.userposts.Fragments.PostFragment;
import com.example.prakhargautam.userposts.Fragments.UserFragment;
import com.example.prakhargautam.userposts.models.Post;
import com.example.prakhargautam.userposts.models.User;

public class PostActivity extends AppCompatActivity implements PostFragment.onPassPostId{

    static int REQUEST_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        setTitle("Posts");

        Intent i=getIntent();
        PostFragment pf=(PostFragment) getFragmentManager().findFragmentById(R.id.post_fragment);
        pf.CreatePostList(i.getIntExtra("userId", 1));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.create_post){
            Intent i= new Intent();
            i.putExtra("calling_activity","post");
            i.setClass(PostActivity.this,AddActivity.class);
            startActivityForResult(i, REQUEST_CODE);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Post post = (Post) data.getSerializableExtra("new_post");
        PostFragment postFragment=(PostFragment) getFragmentManager().findFragmentById(R.id.post_fragment);
        postFragment.createNewPost(post);
    }

    @Override
    public void onPassPostId(int id) {
            Intent i = new Intent();
            i.putExtra("postId", id);
            i.setClass(PostActivity.this, CommentActivity.class);
            startActivity(i);
    }
}
