package com.example.prakhargautam.userposts.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.prakhargautam.userposts.Adapters.CommentAdapter;
import com.example.prakhargautam.userposts.Network.ApiClient;
import com.example.prakhargautam.userposts.R;
import com.example.prakhargautam.userposts.models.Comments;
import com.example.prakhargautam.userposts.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by prakhargautam on 23/03/16.
 */
public class CommentFragment extends Fragment{

    ArrayList<Comments> comments;
    CommentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.comment_fragment,container,false);

        ListView commentListView= (ListView) v.findViewById(R.id.comment_listView);
        comments= new ArrayList<>();

        adapter=new CommentAdapter(getActivity(),comments);

        commentListView.setAdapter(adapter);

        return v;
    }

    public void CreateCommentList(int id) {
        Call<ArrayList<Comments>> commentCall= ApiClient.getInterface().getComments(id);
        commentCall.enqueue(new Callback<ArrayList<Comments>>() {
            @Override
            public void onResponse(Call<ArrayList<Comments>> call, Response<ArrayList<Comments>> response) {
                ArrayList<Comments> commentsList=response.body();
                for(int i=0;i<commentsList.size();i++){
                    comments.add(i,commentsList.get(i));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Comments>> call, Throwable t) {

            }
        });
    }
}
