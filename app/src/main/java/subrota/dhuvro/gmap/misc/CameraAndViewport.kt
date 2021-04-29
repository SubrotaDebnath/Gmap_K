package subrota.dhuvro.gmap.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class CameraAndViewport {
    val lareye: CameraPosition = CameraPosition.builder()
            .target(LatLng(23.752454104507855, 90.36467349555026))
            .bearing(0f)
            .tilt(45f)
            .zoom(16f)
            .build()
}