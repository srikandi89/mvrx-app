package com.example.mvrx.modules.my

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.*
import com.example.mvrx.MvRxApplication

import com.example.mvrx.R
import com.example.mvrx.core.MvRxViewModel
import com.example.mvrx.repository.User
import com.example.mvrx.repository.UserRepository
import kotlinx.android.parcel.Parcelize
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

data class UserProfileState(val user: Async<User> = Uninitialized) : MvRxState

class UserProfileViewModel(
    initialState: UserProfileState,
    private val userId: String,
    private val userRepository: UserRepository) : MvRxViewModel<UserProfileState>(initialState) {

    fun fetchUser() = userRepository.getUser(userId).execute { copy(user = it) }

    companion object : MvRxViewModelFactory<UserProfileViewModel, UserProfileState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: UserProfileState
        ): UserProfileViewModel? {
            val userId = viewModelContext.args<UserProfileArgs>().userId
            val userRepository = viewModelContext.app<MvRxApplication>().userRepository
            return UserProfileViewModel(state, userId, userRepository)
        }
    }
}

@Parcelize
data class UserProfileArgs(val userId: String) : Parcelable

class UserProfileFragment : BaseMvRxFragment() {

    private val viewModel: UserProfileViewModel by fragmentViewModel()

    override fun invalidate() = withState(viewModel) {
        title.text = it.user.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title.setOnClickListener() {
            viewModel.fetchUser()
        }
    }

    companion object {
        private const val ARG_USER_ID = "user_id"

        fun newInstance(userId: String) : UserProfileFragment {
            val fragment = UserProfileFragment()
            val args = Bundle()
            args.putParcelable(MvRx.KEY_ARG, UserProfileArgs("34"))
            fragment.arguments = args
            return fragment
        }
    }
}
