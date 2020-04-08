package com.example.mvrx.modules.my

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.*

import com.example.mvrx.R
import com.example.mvrx.core.MvRxViewModel
import kotlinx.android.synthetic.main.fragment_user_profile.*
import java.lang.IllegalArgumentException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

data class UserProfileState(val userId: String) : MvRxState

class UserProfileViewModel(initialState: UserProfileState) : MvRxViewModel<UserProfileState>(initialState) {
    companion object : MvRxViewModelFactory<UserProfileViewModel, UserProfileState> {
        override fun initialState(viewModelContext: ViewModelContext): UserProfileState? {
            val userId = (viewModelContext as FragmentViewModelContext).fragment<UserProfileFragment>().getUserId()
            return UserProfileState(userId)
        }
    }
}

class UserProfileFragment : BaseMvRxFragment() {

    private val viewModel: UserProfileViewModel by fragmentViewModel()

    override fun invalidate() = withState(viewModel) {
        title.text = it.userId
    }

    fun getUserId() = arguments?.getString(ARG_USER_ID) ?: throw IllegalArgumentException("User id have to be provided")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    companion object {
        private const val ARG_USER_ID = "user_id"

        fun newInstance(userId: String) : UserProfileFragment {
            val fragment = UserProfileFragment()
            val args = Bundle()
            args.putString(ARG_USER_ID, userId)

            fragment.arguments = args
            return fragment
        }
    }
}
