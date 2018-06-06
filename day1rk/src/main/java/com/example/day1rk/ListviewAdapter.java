package com.example.day1rk;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

/**
 * Created by lenovo on 2018/6/6.
 */

class ListviewAdapter extends BaseAdapter {
    private List<bean1.DataBean.NormalBean.ListBeanX>data;
    private Context context;
    private final DisplayImageOptions imageOptions;

    public ListviewAdapter(List<bean1.DataBean.NormalBean.ListBeanX> data, Context context) {
        this.data = data;
        this.context = context;

        imageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//使用内存缓存
                .cacheOnDisk(true)//使用磁盘缓存
                .showImageOnLoading(R.mipmap.ic_launcher)//设置正在下载的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)//url为空或请求的资源不存在时
                .showImageOnFail(R.mipmap.ic_launcher)//下载失败时显示的图片
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片色彩模式  1px=2个字节  ARGB_8888 1px=4个字节   ARGB_4444 1px=2个字节  ALPHA_8 1px=1个字节
                .imageScaleType(ImageScaleType.EXACTLY)//设置图片的缩放模式
                .displayer(new RoundedBitmapDisplayer(100))//设置图片的圆角 注意：控件必须要设定宽度与高度
                .build();
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null){
            view=View.inflate(context,R.layout.item,null);
            holder=new ViewHolder();
            holder.tv=view.findViewById(R.id.tv);
            holder.tv3=view.findViewById(R.id.tv3);
            holder.img=view.findViewById(R.id.img);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.tv.setText(data.get(i).getContent());
        holder.tv3.setText(data.get(i).getCtime());
        ImageLoader.getInstance().displayImage(data.get(i).getUser().getProfile_image(),holder.img,imageOptions);

        return view;
    }
    class ViewHolder{

        public TextView tv,tv3;
        public ImageView img;
    }

}
