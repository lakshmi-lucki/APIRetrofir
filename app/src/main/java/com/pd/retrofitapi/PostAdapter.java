package com.pd.retrofitapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<Post> postList;
    Context context;

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        postList = posts;

    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.items, parent, false );
        return new PostViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        Post post = postList.get( position );
        holder.id.setText( "id : " + post.getId() );
        holder.userId.setText( "userId : " + post.getUserId() );
        holder.title.setText( "title :" + post.getTitle() );
        holder.body.setText( "body :" + post.getBody() );
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView title, id, userId, body;

        public PostViewHolder(@NonNull View itemView) {
            super( itemView );
            title = itemView.findViewById( R.id.title_tv );
            id = itemView.findViewById( R.id.id_tv );
            userId = itemView.findViewById( R.id.user_id_tv );
            body = itemView.findViewById( R.id.body_tv );
        }
    }
}
