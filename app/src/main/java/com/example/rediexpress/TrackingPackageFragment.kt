package com.example.rediexpress

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rediexpress.databinding.SendAPackageThirdFragmentBinding
import com.example.rediexpress.databinding.TrackingPackageFragmentBinding
import com.example.rediexpress.databinding.WalletFragmentBinding
import com.example.rediexpress.presentation.screen.order.SendAPackageThirdFragment
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint

class TrackingPackageFragment : Fragment() {

    lateinit var binding: TrackingPackageFragmentBinding

    lateinit var mainActivity: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TrackingPackageFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mainActivity = activity as MainActivity

        binding.map.setTileSource(TileSourceFactory.MAPNIK)

        binding.map.controller.setZoom(10.0)
        binding.map.controller.setCenter(GeoPoint(42.0, 47.0))

        binding.map.setMultiTouchControls(true)

        binding.viewPackageBtn.setOnClickListener {

            parentFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, SendAPackageThirdFragment(), "tracking")
                .addToBackStack(null)
                .commit()

        }

    }

}