package com.example.fragmenttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {

            return ComposeView(
                requireContext()).apply {
                setContent {
                    Image(painter = painterResource(id = R.drawable.background1),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds)
                    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 250.dp, horizontal = 15.dp),
                        verticalArrangement = Arrangement.spacedBy(150.dp)
                    ) {
                        item() {
                            ComposeButton(
                                text = context.getString(R.string.menu),
                                fn = ::openMenu)
                        }
                        item{
                            ComposeButton(
                                text = context.getString(R.string.settings),
                                fn = ::openSettings
                            )
                        }
                    }
                }
            }
        }

    fun openMenu(){
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FirstFragment.newInstance())
            .commit()
    }

    fun openSettings(){
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SecondFragment.newInstance())
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment()
    }

    override fun onSaveInstanceState(outState : Bundle) {
        super.onSaveInstanceState(outState);
    }
}