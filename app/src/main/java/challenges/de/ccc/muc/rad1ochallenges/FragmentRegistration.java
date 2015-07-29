package challenges.de.ccc.muc.rad1ochallenges;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentRegistration.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentRegistration#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRegistration extends Fragment implements View.OnClickListener {

      EditText badgeIdText;
      EditText badgeSecretKeyText;
      EditText nickNameText;
      EditText callSignText;
      EditText emailText;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRegistration.
     */
    // TODO: Rename and change types and number of parameters


    public FragmentRegistration() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_fragment_registration, container, false);
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        badgeIdText = (EditText) activity.findViewById(R.id.editText);
        badgeSecretKeyText = (EditText) activity.findViewById(R.id.editText2);
        nickNameText = (EditText) activity.findViewById(R.id.editText3);
        callSignText = (EditText) activity.findViewById(R.id.editText4);
        emailText = (EditText) activity.findViewById(R.id.editText5);


    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.registerButton){
            //TODO
        }
    }
}
