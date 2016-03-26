package com.example.prakhargautam.userposts.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.prakhargautam.userposts.R;
import com.example.prakhargautam.userposts.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prakhargautam on 23/03/16.
 */
public class UserAdapter extends ArrayAdapter<User> {
    Context context;
    ArrayList<User> users;

    public UserAdapter(Context context, ArrayList<User> objects) {
        super(context, 0, objects);
        this.context=context;
        users=objects;
    }

    public class ViewHolder{
        TextView nameTextView;
        TextView usernameTextView;
        TextView emailTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=View.inflate(context, R.layout.user_layout,null);
            ViewHolder vh=new ViewHolder();
            vh.nameTextView=(TextView) convertView.findViewById(R.id.name);
            vh.usernameTextView=(TextView) convertView.findViewById(R.id.username);
            vh.emailTextView=(TextView) convertView.findViewById(R.id.email);
            convertView.setTag(vh);
        }
        ViewHolder vh= new ViewHolder();
        vh=(ViewHolder) convertView.getTag();
        User user=users.get(position);
        vh.nameTextView.setText(user.getName());
        vh.emailTextView.setText(user.getEmail());
        vh.usernameTextView.setText(user.getUserName());

        return convertView;
    }
}
