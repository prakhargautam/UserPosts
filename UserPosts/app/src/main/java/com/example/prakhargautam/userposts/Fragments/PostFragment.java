package com.example.prakhargautam.userposts.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.prakhargautam.userposts.Adapters.PostAdapter;
import com.example.prakhargautam.userposts.Network.ApiClient;
import com.example.prakhargautam.userposts.R;
import com.example.prakhargautam.userposts.models.Post;
import com.example.prakhargautam.userposts.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by prakhargautam on 23/03/16.
 */
public class PostFragment extends Fragment {

    onPassPostId passPostId;
    ArrayList<Post> posts;
    PostAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.post_fragment,container,false);

        ListView postListView= (ListView) v.findViewById(R.id.post_listView);
        posts= new ArrayList<>();

        adapter=new PostAdapter(getActivity(),posts);

        postListView.setAdapter(adapter);

        postListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                passPostId=(onPassPostId) getActivity();
                passPostId.onPassPostId(posts.get(position).getId());
            }
        });

        return v;
    }
    public void CreatePostList(int id){
        Call<ArrayList<Post>> postsCall=ApiClient.getInterface().getPosts(id);
        postsCall.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                ArrayList<Post> returnedPosts = response.body();
                for(int i=0;i<returnedPosts.size();i++){
                    posts.add(i, returnedPosts.get(i));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });
    }
    public interface onPassPostId{
        void onPassPostId(int id);
    }
}
