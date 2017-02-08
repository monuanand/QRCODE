package com.example.survograph;



import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.survograph.R;

 
public class Adapter extends BaseAdapter {
 
    ArrayList<String> lstPermission;
  
    Activity context;
   
 
    public Adapter(Activity context, ArrayList<String>lstPermission,
    		ArrayList<String> lstRisk) {
        super();
        this.context = context;
        this.lstPermission = lstPermission;
      
       
    }
 
    private class ViewHolder {
        TextView tvPermission;
      
      
    }
 
    public long getItemId(int position) {
        return 0;
    }
 
    @SuppressLint("InflateParams")
	public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = context.getLayoutInflater();
 
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custum_list1, null);
            holder = new ViewHolder();
 
            holder.tvPermission = (TextView) convertView.findViewById(R.id.textView1);
           
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
 
      
   
        holder.tvPermission.setText(lstPermission.get(position));
       
     
        return convertView;
    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		  return lstPermission.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		 return lstPermission.get(position);
	}
}