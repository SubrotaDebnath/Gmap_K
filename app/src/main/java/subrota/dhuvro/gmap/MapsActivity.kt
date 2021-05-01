package subrota.dhuvro.gmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import subrota.dhuvro.gmap.misc.CameraAndViewport
import subrota.dhuvro.gmap.misc.TypeAndStyle

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private val typeAndStyle by lazy { TypeAndStyle() }
    private val cameraAndViewport by lazy { CameraAndViewport() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_types_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       typeAndStyle.setMapType(item, mMap)
        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        //val lareye = LatLng(23.752454104507855, 90.36467349555026)
        val lareye = LatLng(23.752454104507855, 90.36467349555026)
        //val home = LatLng(23.223679060611627, 89.40584862018646)
        mMap.addMarker(MarkerOptions().position(lareye).title("Marker in Lareye"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lareye, 15f))
        //mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewport.lareye))
        mMap.uiSettings.apply {
            isZoomControlsEnabled = true

            //enabled option are
//            isZoomGesturesEnabled = true
//            isScrollGesturesEnabled = true
//            isMyLocationButtonEnabled = true
//            isMapToolbarEnabled = true
        }

        typeAndStyle.setMapStyle(mMap, this)



        /*lifecycleScope.launch {
            delay(3000L)

            //camera animation with out call back
            //mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewport.lareye), 2000, null)

            //camera animation with callback
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewport.lareye), 2000, object : GoogleMap.CancelableCallback{
                override fun onFinish() {
                    //do something on Finish
                }

                override fun onCancel() {
                    //do something on Cancel
                }

            })

            //camera update
            //mMap.moveCamera(CameraUpdateFactory.newLatLng(home))

            //Camera bounds
            //mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(cameraAndViewport.jessoreBound, 0))

            //map scrolling Restrict
           // mMap.setLatLngBoundsForCameraTarget(cameraAndViewport.jessoreBound)

            //map bound and center point
            //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cameraAndViewport.jessoreBound.center, 10f))

            //new marker title
            //mMap.addMarker(MarkerOptions().position(home).title("Marker on Home"))
        }
*/

//        lifecycleScope.launch {
//            delay(3000L)
//            mMap.moveCamera(CameraUpdateFactory.zoomBy(2f))
//            delay(3000L)
//            mMap.moveCamera(CameraUpdateFactory.zoomBy(2f))
//        }

        //mMap.setPadding(0,0,300,0)

        onMapClick()
        onMapLongClick()

    }

    fun onMapClick(){
        mMap.setOnMapClickListener {
            Toast.makeText(this, "new marker added", Toast.LENGTH_SHORT).show()
            mMap.addMarker(MarkerOptions().position(it).title(" new Marker"))
        }
    }

    fun onMapLongClick(){
        mMap.setOnMapLongClickListener {
            Toast.makeText(this, "Latitude: ${it.latitude} \nLongitude: ${it.longitude}", Toast.LENGTH_SHORT).show()
        }
    }



}