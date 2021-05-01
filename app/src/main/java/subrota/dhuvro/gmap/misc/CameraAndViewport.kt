package subrota.dhuvro.gmap.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class CameraAndViewport {
    val lareye: CameraPosition = CameraPosition.builder()
            .target(LatLng(23.752454104507855, 90.36467349555026))
            .bearing(0f)
            .tilt(45f)
            .zoom(16f)
            .build()

    val jessoreBound = LatLngBounds(

            LatLng(23.13906333953982, 89.13415212114967), //SW
            LatLng(23.203135869781846, 89.21895283827726) //NE

    )
}

