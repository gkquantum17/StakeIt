package com.example.gokul.favr_v2;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

/**
 "? * Created by hp1 on 21-01-2015.
  */
public class Tab2 extends Fragment{

    protected List<ParseObject> qPosts;
    protected List<ParseObject> tPosts;
    protected List<ParseObject> pPosts;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2, container, false);
        final ListView listView = (ListView)v.findViewById(R.id.listViewPosts);
        ParseUser currentUser = ParseUser.getCurrentUser();
        String title = getActivity().getTitle().toString();
       // Toast.makeText(getActivity(), title + "adsf" , Toast.LENGTH_SHORT).show();
        switch (title){
            case "Sports":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                    query.whereEqualTo("category", "Sports");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(getActivity(), qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Business":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                    query.whereEqualTo("category", "Business");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(getActivity(), qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "U.S.":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                    query.whereEqualTo("category", "U.S");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(getActivity(), qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "World":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                    query.whereEqualTo("category", "World");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(getActivity(), qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Politics":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                    query.whereEqualTo("category", "Politics");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(getActivity(), qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Science":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                    query.whereEqualTo("category", "Science");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(getActivity(), qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Technology":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                    query.whereEqualTo("category", "Technology");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(getActivity(), qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Automobiles":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                    query.whereEqualTo("category", "automobiles");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(getActivity(), qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Economy":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                    query.whereEqualTo("category", "economy");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(getActivity(), qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Education":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                    query.whereEqualTo("category", "education");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(getActivity(), qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            default:
                break;
        }
        return v;
    }
}