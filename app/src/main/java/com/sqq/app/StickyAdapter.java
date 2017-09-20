package com.sqq.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;

/**
 * @author shuaiqiangqiang
 * @version 1.0 2017/9/4
 * @since JDK 1.7
 */
public class StickyAdapter extends RecyclerView.Adapter<StickyAdapter.ViewHolder> {

    private List<Sticky> mDatas;
    private Context mContext;

    public StickyAdapter(Context context, List<Sticky> list) {
        mContext = context;
        mDatas = list;
    }

    @Override
    public StickyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.sticky_item, parent, false));
    }

    @Override
    public void onBindViewHolder(StickyAdapter.ViewHolder holder, int position) {
        Sticky sticky = mDatas.get(position);
        holder.textView.setText(sticky.getName());
        holder.gridView.setAdapter(new GridAdapter(mContext, 0, sticky.getList(), holder.gridView.getNumColumns()));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        GridView gridView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_city);
            gridView = (GridView) itemView.findViewById(R.id.grid_view);
        }
    }

    class GridAdapter extends ArrayAdapter<String> {

        private int columnCount;  // 列个数

        public GridAdapter(Context context, int resource, List<String> objects, int count) {
            super(context, resource, objects);
            columnCount = count;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            GridViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item, parent, false);
                holder = new GridViewHolder();
                holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
                holder.view = convertView.findViewById(R.id.view);
                convertView.setTag(holder);
            } else {
                holder = (GridViewHolder) convertView.getTag();
            }

            int round = getCount() % 4;
            System.out.println("===" + (getCount() - round));
            if (position < getCount() - round) {
                holder.view.setVisibility(View.VISIBLE);
            } else {
                holder.view.setVisibility(View.GONE);
            }
            holder.tvName.setText(getItem(position));
            return convertView;
        }
    }

    class GridViewHolder {
        View view;
        TextView tvName;
    }

}
