package cn.edu.bistu.cs.se.zuoye13;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.edu.bistu.cs.se.zuoye13.Words.WordsContent;


public class DetailFragment extends Fragment {

    private static final String ARG_PARAM1="id";
    private static final String ARG_PARAM2="param2";
    private  String mParam1 ;
    private  String mParam2;


    public DetailFragment(){

    }

    public static DetailFragment newInstance(String param1,String param2){
        DetailFragment fragment=new DetailFragment();
        Bundle args=new Bundle();
        args.putString(ARG_PARAM1,param1);
        args.putString(ARG_PARAM2,param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        if(getArguments()!=null){
            mParam1=getArguments().getString(ARG_PARAM1);
            mParam2=getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detail, container, false);
        TextView textViewWord=(TextView)view.findViewById(R.id.word);
        TextView textViewMeaning=(TextView)view.findViewById(R.id.wordmeaning);
        TextView textViewSample=(TextView)view.findViewById(R.id.wordsample);
        switch (mParam1){
            case "1":
                textViewWord.setText("apple");
                textViewMeaning.setText("苹果");
                textViewSample.setText("Apple hit Newton on the head.");
                break;
            case "2":
                textViewWord.setText("Banana");
                textViewMeaning.setText("香蕉");
                textViewSample.setText("This orange is very nice.");
                break;
            case "3":
                textViewWord.setText("Cral");
                textViewMeaning.setText("螃蟹");
                textViewSample.setText("Thousands of herring and crab are washed up on the beaches during every storm.");
                break;
            case "4":
                textViewWord.setText("infer");
                textViewMeaning.setText("推断，猜测");
                textViewSample.setText("be inferred from context");
        }
        return view;
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }
    private OnFragmentInteractionListener mListener;

    public void onButtonPressed(Uri uri){
        if(mListener!=null){
            mListener.onFragmentInteraction(uri);
        }
    }

    public void onDetach(){
        super.onDetach();
        mListener=null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}