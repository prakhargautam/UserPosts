package com.example.prakhargautam.userposts.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.prakhargautam.userposts.R;
import com.example.prakhargautam.userposts.models.Comments;
import com.example.prakhargautam.userposts.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prakhargautam on 23/03/16.
 */
public class CommentAdapter extends ArrayAdapter<Comments> {
    Context context;
    ArrayList<Comments> comments;

    public CommentAdapter(Context context, ArrayList<Comments> objects) {
        super(context, 0, objects);
        this.context=context;
        comments=objects;
    }

    public class ViewHolder{
        TextView nameTextView;
        TextView bodyTextView;
        TextView emailTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=View.inflate(context, R.layout.comment_layout,null);
            ViewHolder vh=new ViewHolder();
            vh.nameTextView=(TextView) convertView.findViewById(R.id.name);
            vh.bodyTextView=(TextView) convertView.findViewById(R.id.body);
            vh.emailTextView=(TextView) convertView.findViewById(R.id.email);
            convertView.setTag(vh);
        }
        ViewHolder vh= (ViewHolder) convertView.getTag();
        Comments comment=comments.get(position);
        vh.nameTextView.setText(comment.getName());
        vh.emailTextView.setText(comment.getEmail());
        vh.bodyTextView.setText(comment.getBody());

        return convertView;
    }
}
