package com.example.prakhargautam.userposts.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.prakhargautam.userposts.R;
import com.example.prakhargautam.userposts.models.Post;
import com.example.prakhargautam.userposts.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prakhargautam on 23/03/16.
 */
public class PostAdapter extends ArrayAdapter<Post> {
    Context context;
    ArrayList<Post> posts;

    public PostAdapter(Context context, ArrayList<Post> objects) {
        super(context, 0, objects);
        this.context=context;
        posts=objects;
    }

    public class ViewHolder{
        TextView titleTextView;
        TextView bodyTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=View.inflate(context, R.layout.post_layout,null);
            ViewHolder vh=new ViewHolder();
            vh.titleTextView=(TextView) convertView.findViewById(R.id.title);
            vh.bodyTextView=(TextView) convertView.findViewById(R.id.body);
            convertView.setTag(vh);
        }
        ViewHolder vh= (ViewHolder) convertView.getTag();
        Post post=posts.get(position);
        vh.titleTextView.setText(post.getTitle());
        vh.bodyTextView.setText(post.getBody());

        return convertView;
    }
}
