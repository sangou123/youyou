package com.example.mall.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter {
    public Context mcontext;
    protected List<T> data=new ArrayList<>();
    private IClick iClick;
    public void setiClick(IClick ck){
        this.iClick=ck;
    }
    public BaseAdapter(Context context){

        this.mcontext=context;
    }

    public void setData(List<T> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(mcontext).inflate(getLayout(), null);
        final BaseViewHolder baseViewHolder = new BaseViewHolder(inflate);
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iClick!=null){
                    iClick.click(baseViewHolder.getLayoutPosition()
                            ,data.get(baseViewHolder.getLayoutPosition()));
                }
            }
        });
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BaseViewHolder vh=(BaseViewHolder) holder;
        T _data=data.get(position);
        bindData(vh,_data);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //获得当前适配器绑定的布局
    protected abstract int getLayout();
    //绑定数据
    protected abstract void bindData(BaseViewHolder vh,T data);

    //接口回调
    public interface IClick<T> {
        void click(int pos, T da);
    }


    //基类适配器
    public class BaseViewHolder extends RecyclerView.ViewHolder{
        SparseArray views=new SparseArray();
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        //通过id获取适配器的组件
        public View getViewById(int id){
            View view= (View) views.get(id);
            if (view==null){
                view=itemView.findViewById(id);
                views.append(id,view);
            }
            return view;
        }
    }
}
