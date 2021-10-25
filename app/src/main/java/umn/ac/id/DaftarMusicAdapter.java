package umn.ac.id;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class DaftarMusicAdapter extends
        RecyclerView.Adapter<DaftarMusicAdapter.ItemMusicViewHolder> {
    private LinkedList<SumberMusic> mDaftarMusic;
    private LayoutInflater mInflater;
    private Context mContext;

    public DaftarMusicAdapter(Context context, LinkedList<SumberMusic> daftarMusic){
        this.mContext = context;
        this.mDaftarMusic = daftarMusic;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DaftarMusicAdapter.ItemMusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.music_item_layout,
                parent, false);
        return new ItemMusicViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarMusicAdapter.ItemMusicViewHolder holder, int position) {
        SumberMusic mSumberMusic = mDaftarMusic.get(position);
        holder.tvJudul.setText(mSumberMusic.getJudul());
        holder.tvKeterangan.setText(mSumberMusic.getKeterangan());

    }

    @Override
    public int getItemCount() {
        return mDaftarMusic.size();
    }

    class ItemMusicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvJudul;
        private TextView tvKeterangan;
        private TextView tvUri;
        private ImageView delete;
        private DaftarMusicAdapter mAdapter;
        private int mPosisi;
        private SumberMusic mSumberMusic;

        public ItemMusicViewHolder(@NonNull View itemView, DaftarMusicAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvKeterangan = (TextView) itemView.findViewById(
                    R.id.tvKeterangan);
            itemView.setOnClickListener(this);
            delete = itemView.findViewById(R.id.delete);
            delete.setOnClickListener(view -> delete(getPosition()));
        }
        @Override
        public void onClick(View v) {
            mPosisi = getLayoutPosition();
            mSumberMusic = mDaftarMusic.get(mPosisi);
            Intent detilInten = new Intent(mContext,
                    DetilMusicActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("DetilMusic", mSumberMusic);
            detilInten.putExtras(bundle);
            mContext.startActivity(detilInten);
        }
        public void delete(int delete) {
            mDaftarMusic.remove(delete);
            notifyItemRemoved(delete);
            notifyItemRangeChanged(delete, mDaftarMusic.size());
        }
    }
}
