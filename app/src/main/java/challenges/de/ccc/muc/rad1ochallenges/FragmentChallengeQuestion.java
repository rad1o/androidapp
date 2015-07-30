package challenges.de.ccc.muc.rad1ochallenges;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nicolas on 30.07.2015.
 */
public class FragmentChallengeQuestion extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_challenge_question, container, false);
    }
}
