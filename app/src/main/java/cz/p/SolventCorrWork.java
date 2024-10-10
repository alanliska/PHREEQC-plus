package cz.p;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import cz.p.MainActivity;

public class SolventCorrWork extends SolventCorr {

    public boolean selection[];
    public File[] files;
    public List<String> filesList;
    public int filesFindCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.generallayout);
        final String rootPath = getFilesDir()+"/output/phreeqc_datasets";
        final File dir = new File(rootPath);
        files = dir.listFiles();
        final TextView pathOutput = findViewById(R.id.pathOutput);
        pathOutput.setText(rootPath.substring(rootPath.lastIndexOf('/')+1));
        filesFindCount = files.length;
        final ListView listView = findViewById(R.id.listView);

        final TextAdapter textAdapter1 = new TextAdapter();
        listView.setAdapter(textAdapter1);

        filesList = new ArrayList<>();
        for (int i=0;i<filesFindCount;i++){
            filesList.add(String.valueOf(files[i].getAbsolutePath()));
        }
        textAdapter1.setData(filesList);

        selection = new boolean[files.length];

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selection[position]=!selection[position];
                textAdapter1.setSelection(selection);

                boolean isAtleastOneSelected = false;
                for(boolean aSelection : selection){
                    if(aSelection){
                        isAtleastOneSelected = true;

                        break;
                    }
                }
                if(isAtleastOneSelected){
//                            findViewById(R.id.bottomBar).setVisibility(View.VISIBLE);
                    for(int i = 0; i<files.length;i++){
                        if(selection[i]){
                            selectFileOrFolder(files[i]);
                            selection[i] = false;
                        }
                    }
                    files = dir.listFiles();
                    filesFindCount = files.length;
                    filesList.clear();
                    for (int i=0;i<filesFindCount;i++){
                        filesList.add(String.valueOf(files[i].getAbsolutePath()));
                    }
                    textAdapter1.setData(filesList);
                    returnBackToMainActivity();
                }else{
                }
                return false;
            }
        });
    }

    // Executes UNIX command.
    private String exec(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[65536];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();
            process.waitFor();
            return output.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    class TextAdapter extends BaseAdapter {

        public List<String> data = new ArrayList<>();

        public boolean selection[];

        public void setData(List<String> data){
            if (data!= null){
                this.data.clear();
                if (data.size() > 0){
                    this.data.addAll(data);
                }
                notifyDataSetChanged();
            }
        }

        void setSelection(boolean[] selection){
            if(selection!=null){
                this.selection = new boolean[selection.length];
                for(int i=0;i<selection.length;i++){
                    this.selection[i] = selection[i];
                }
                notifyDataSetChanged();
            }
        }
        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public String getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
                convertView.setTag(new ViewHolder((TextView) convertView.findViewById(R.id.textItem)));
            }
            ViewHolder holder = (ViewHolder) convertView.getTag();
            final String item = getItem(position);
            holder.info.setText(item.substring(item.lastIndexOf('/')+1));
            if(selection!=null){
                if(selection[position]){
                    holder.info.setBackgroundColor(Color.GRAY);
                }else{
                    holder.info.setBackgroundColor(Color.WHITE);
                }

            }
            return convertView;
        }

        class ViewHolder{
            TextView info;
            ViewHolder(TextView info){
                this.info = info;
            }
        }

    }

    public void selectFileOrFolder(File fileOrFolder){

        final String SelectedFile = fileOrFolder.getAbsolutePath();
        exec("cp "+SelectedFile+" "+getFilesDir()+"/SolventFragment.txt");
    }

    private void returnBackToMainActivity() {
        Intent intent = new Intent(SolventCorrWork.this, SolventCorr.class);
        startActivity(intent);
        onResume();
    }

    public void deleteFileOrFolder(File fileOrFolder){
        if(fileOrFolder.isDirectory()){
            if(fileOrFolder.list().length==0){
                fileOrFolder.delete();
            }else{
                String files[] = fileOrFolder.list();
                for(String temp:files){
                    File fileToDelete = new File(fileOrFolder, temp);
                    deleteFileOrFolder(fileToDelete);
                }
                if(fileOrFolder.list().length==0){
                    fileOrFolder.delete();
                }
            }
        }else{
            fileOrFolder.delete();
        }
    }
}