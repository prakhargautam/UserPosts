package com.example.prakhargautam.userposts.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.prakhargautam.userposts.Network.ApiClient;
import com.example.prakhargautam.userposts.R;
import com.example.prakhargautam.userposts.Adapters.UserAdapter;
import com.example.prakhargautam.userposts.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by prakhargautam on 23/03/16.
 */
public class UserFragment extends Fragment{

    onPassId passId;
    ArrayList<User> users;
    UserAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.user_fragment,container,false);
        ListView userListView= (ListView) v.findViewById(R.id.user_listView);
        users= new ArrayList<>();

        adapter=new UserAdapter(getActivity(),users);

        userListView.setAdapter(adapter);

        Call<ArrayList<User>> UserCall= ApiClient.getInterface().getUser();
        UserCall.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                ArrayList<User> returnedUsers = response.body();
                for(int i=0;i<returnedUsers.size();i++){
                    users.add(i,returnedUsers.get(i));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });

        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                passId=(onPassId) getActivity();
                passId.onPass(users.get(position).getId());
            }
        });


        return v;
    }

    public interface onPassId{
        void onPass(int id);
        void createNewUser();
    }
}
