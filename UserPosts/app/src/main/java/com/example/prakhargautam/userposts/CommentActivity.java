package com.example.prakhargautam.userposts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.prakhargautam.userposts.Fragments.CommentFragment;
import com.example.prakhargautam.userposts.Fragments.UserFragment;
import com.example.prakhargautam.userposts.models.User;

public class CommentActivity extends AppCompatActivity {

    static final int REQUEST_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        setTitle("Comments");

        Intent i=getIntent();
        CommentFragment cf=(CommentFragment) getFragmentManager().findFragmentById(R.id.comment_fragment);
        cf.CreateCommentList(i.getIntExtra("postId",1));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.comment_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.create_comment){
            Intent i= new Intent();
            i.putExtra("calling_activity","comment");
            i.setClass(CommentActivity.this,AddActivity.class);
            startActivity(i);
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
}
