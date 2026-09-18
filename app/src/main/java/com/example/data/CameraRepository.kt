package com.example.data

import com.example.model.Country
import com.example.model.LiveCamera

object CameraRepository {

    val countries = listOf(
        Country(
            id = "usa",
            name = "USA",
            flag = "🇺🇸",
            subtitle = "Metropolitan Highways & Intersections",
            cameraCount = 6,
            badgeColorHex = 0xFF38BDF8
        ),
        Country(
            id = "uk",
            name = "UK",
            flag = "🇬🇧",
            subtitle = "Historic Crossings & Ring Roads",
            cameraCount = 5,
            badgeColorHex = 0xFFFF5252
        ),
        Country(
            id = "japan",
            name = "Japan",
            flag = "🇯🇵",
            subtitle = "High-Density Expressways & Scrambles",
            cameraCount = 5,
            badgeColorHex = 0xFFFF4081
        ),
        Country(
            id = "pakistan",
            name = "Pakistan",
            flag = "🇵🇰",
            subtitle = "Major Boulevards & Coastal Drives",
            cameraCount = 5,
            badgeColorHex = 0xFF00E676
        ),
        Country(
            id = "germany",
            name = "Germany",
            flag = "🇩🇪",
            subtitle = "Autobahn Corridors & City Centers",
            cameraCount = 5,
            badgeColorHex = 0xFFFFD700
        ),
        Country(
            id = "canada",
            name = "Canada",
            flag = "🇨🇦",
            subtitle = "Downtown Squares & Mountain Parkways",
            cameraCount = 5,
            badgeColorHex = 0xFFFF5252
        )
    )

    val allCameras = listOf(
        // ==================== USA ====================
        LiveCamera(
            id = "usa_times_square",
            title = "Times Square 4K Street & Traffic",
            city = "New York City",
            countryId = "usa",
            countryName = "USA",
            flag = "🇺🇸",
            youtubeVideoId = "1-iS7LArMPA",
            locationDescription = "Broadway & 7th Ave Intersection, Midtown Manhattan",
            cameraType = "4K Live Feed",
            viewersCount = "4.8K",
            trafficStatus = "Heavy Congestion",
            tags = listOf("EarthCam", "Broadway", "Pedestrian Scramble", "Manhattan")
        ),
        LiveCamera(
            id = "usa_jackson_hole",
            title = "Jackson Hole Town Square Intersection",
            city = "Jackson Hole",
            countryId = "usa",
            countryName = "USA",
            flag = "🇺🇸",
            youtubeVideoId = "1EIx86wJ88Q",
            locationDescription = "Broadway & Center St, Historic Town Square",
            cameraType = "Traffic & Wildlife",
            viewersCount = "1.5K",
            trafficStatus = "Normal Flow",
            tags = listOf("Wyoming", "Intersection", "4-Way Stop", "Town Square")
        ),
        LiveCamera(
            id = "usa_miami_ocean_drive",
            title = "Ocean Drive & 10th Street Live",
            city = "Miami Beach",
            countryId = "usa",
            countryName = "USA",
            flag = "🇺🇸",
            youtubeVideoId = "p0mR9mI1lE4",
            locationDescription = "Ocean Dr & Lummus Park Corridor, South Beach",
            cameraType = "Coastal Road Cam",
            viewersCount = "2.1K",
            trafficStatus = "Moderate Flow",
            tags = listOf("Florida", "Beachside", "Art Deco", "Cruise Traffic")
        ),
        LiveCamera(
            id = "usa_la_santa_monica",
            title = "Santa Monica Pier & Ocean Avenue",
            city = "Los Angeles",
            countryId = "usa",
            countryName = "USA",
            flag = "🇺🇸",
            youtubeVideoId = "9xVpU6sE6lI",
            locationDescription = "Pacific Coast Highway (PCH) & Colorado Ave",
            cameraType = "Highway / Pier Cam",
            viewersCount = "3.2K",
            trafficStatus = "Slow Moving",
            tags = listOf("California", "Pacific Highway", "Route 66", "Sunset")
        ),
        LiveCamera(
            id = "usa_vegas_strip",
            title = "Las Vegas Strip Boulevard",
            city = "Las Vegas",
            countryId = "usa",
            countryName = "USA",
            flag = "🇺🇸",
            youtubeVideoId = "4k_s-v2n5kI",
            locationDescription = "Las Vegas Blvd South & Flamingo Road Intersection",
            cameraType = "Boulevard 4K",
            viewersCount = "5.6K",
            trafficStatus = "Active Flow",
            tags = listOf("Nevada", "The Strip", "Night Lights", "Intersection")
        ),
        LiveCamera(
            id = "usa_new_orleans",
            title = "Bourbon Street & Canal Street Crossing",
            city = "New Orleans",
            countryId = "usa",
            countryName = "USA",
            flag = "🇺🇸",
            youtubeVideoId = "psfF9EZT3c0",
            locationDescription = "French Quarter Historic Corridor",
            cameraType = "Street Cam",
            viewersCount = "1.1K",
            trafficStatus = "Pedestrian & Trolley",
            tags = listOf("Louisiana", "French Quarter", "Streetcar", "Downtown")
        ),

        // ==================== UK ====================
        LiveCamera(
            id = "uk_abbey_road",
            title = "Abbey Road Famous Pedestrian Crossing",
            city = "London",
            countryId = "uk",
            countryName = "UK",
            flag = "🇬🇧",
            youtubeVideoId = "qy4Pz9_y_2Y",
            locationDescription = "Abbey Road Studios, St John's Wood, NW8",
            cameraType = "Live Zebra Crossing",
            viewersCount = "6.2K",
            trafficStatus = "Zebra Yields",
            tags = listOf("Abbey Road", "Beatles", "Zebra Crossing", "Westminster")
        ),
        LiveCamera(
            id = "uk_tower_bridge",
            title = "Tower Bridge & River Thames Traffic",
            city = "London",
            countryId = "uk",
            countryName = "UK",
            flag = "🇬🇧",
            youtubeVideoId = "vFh91u_vVBo",
            locationDescription = "A100 Tower Bridge Approach & River Bascule",
            cameraType = "Bridge Traffic Cam",
            viewersCount = "3.9K",
            trafficStatus = "Controlled Flow",
            tags = listOf("Tower Bridge", "A100", "Bascule Bridge", "Central London")
        ),
        LiveCamera(
            id = "uk_edinburgh_princes",
            title = "Princes Street & Royal Mile Traffic",
            city = "Edinburgh",
            countryId = "uk",
            countryName = "UK",
            flag = "🇬🇧",
            youtubeVideoId = "vP8B6yqC5hE",
            locationDescription = "Princes St Tram Corridor overlooking Edinburgh Castle",
            cameraType = "Transit & Road Cam",
            viewersCount = "1.4K",
            trafficStatus = "Tram & Bus Corridor",
            tags = listOf("Scotland", "Old Town", "Princes St", "Trams")
        ),
        LiveCamera(
            id = "uk_manchester_deansgate",
            title = "Deansgate & Oxford Road Corridor",
            city = "Manchester",
            countryId = "uk",
            countryName = "UK",
            flag = "🇬🇧",
            youtubeVideoId = "z9x0q5e3k8o",
            locationDescription = "City Centre A56 & Great Bridgewater St",
            cameraType = "Urban Arterial",
            viewersCount = "850",
            trafficStatus = "Normal Flow",
            tags = listOf("Manchester", "A56", "Greater Manchester", "City Centre")
        ),
        LiveCamera(
            id = "uk_brighton_seafront",
            title = "Kings Road & Palace Pier Approach",
            city = "Brighton",
            countryId = "uk",
            countryName = "UK",
            flag = "🇬🇧",
            youtubeVideoId = "a8b2c3d4e5f",
            locationDescription = "A259 Coast Road Promenade",
            cameraType = "Coastal Arterial",
            viewersCount = "720",
            trafficStatus = "Moderate Flow",
            tags = listOf("Brighton", "A259", "South Coast", "Promenade")
        ),

        // ==================== JAPAN ====================
        LiveCamera(
            id = "jp_shibuya_scramble",
            title = "Shibuya Scramble Crossing 4K Live",
            city = "Tokyo",
            countryId = "japan",
            countryName = "Japan",
            flag = "🇯🇵",
            youtubeVideoId = "DFsJ8g612a4",
            locationDescription = "Hachiko Square & Shibuya Station Intersection",
            cameraType = "4K Scramble Cam",
            viewersCount = "12.4K",
            trafficStatus = "Multi-Phase Lights",
            tags = listOf("Shibuya", "Scramble", "Tokyo 4K", "Hachiko")
        ),
        LiveCamera(
            id = "jp_shinjuku_kabukicho",
            title = "Shinjuku Kabukicho Gate & Yasukuni-dori",
            city = "Tokyo",
            countryId = "japan",
            countryName = "Japan",
            flag = "🇯🇵",
            youtubeVideoId = "6dp-bvQ7RWo",
            locationDescription = "Yasukuni-dori Blvd & Kabukicho 1-chome Entrance",
            cameraType = "City Boulevard",
            viewersCount = "4.1K",
            trafficStatus = "Heavy Night Flow",
            tags = listOf("Shinjuku", "Kabukicho", "Neon Corridor", "Tokyo")
        ),
        LiveCamera(
            id = "jp_akihabara",
            title = "Akihabara Chuo-dori Electric Town",
            city = "Tokyo",
            countryId = "japan",
            countryName = "Japan",
            flag = "🇯🇵",
            youtubeVideoId = "b8vY7zX8M6o",
            locationDescription = "National Route 17 Chuo-dori Avenue",
            cameraType = "Main Boulevard",
            viewersCount = "2.3K",
            trafficStatus = "Normal Flow",
            tags = listOf("Akihabara", "Route 17", "Electric Town", "Tokyo")
        ),
        LiveCamera(
            id = "jp_osaka_dotonbori",
            title = "Dotonbori Midosuji Avenue & Ebisubashi",
            city = "Osaka",
            countryId = "japan",
            countryName = "Japan",
            flag = "🇯🇵",
            youtubeVideoId = "r0mJ0W_mY7k",
            locationDescription = "Midosuji Boulevard & Dotonbori Canal Bridge",
            cameraType = "Canal & Road Cam",
            viewersCount = "3.8K",
            trafficStatus = "Active Flow",
            tags = listOf("Osaka", "Dotonbori", "Glico", "Midosuji")
        ),
        LiveCamera(
            id = "jp_kyoto_gion",
            title = "Gion Shijo-dori & Yasaka Shrine Approach",
            city = "Kyoto",
            countryId = "japan",
            countryName = "Japan",
            flag = "🇯🇵",
            youtubeVideoId = "d6y7z8a9b0c",
            locationDescription = "Shijo Avenue & Higashiyama Ward Main Street",
            cameraType = "Historic Avenue",
            viewersCount = "1.9K",
            trafficStatus = "Controlled Speed",
            tags = listOf("Kyoto", "Gion", "Shijo Dori", "Historic")
        ),

        // ==================== PAKISTAN ====================
        LiveCamera(
            id = "pk_lahore_liberty",
            title = "Liberty Roundabout & Main Boulevard Gulberg",
            city = "Lahore",
            countryId = "pakistan",
            countryName = "Pakistan",
            flag = "🇵🇰",
            youtubeVideoId = "sT3uE0u18qg",
            locationDescription = "Gulberg III Main Boulevard & Liberty Chowk",
            cameraType = "Roundabout Cam",
            viewersCount = "2.7K",
            trafficStatus = "Flowing Roundabout",
            tags = listOf("Lahore", "Gulberg", "Liberty Chowk", "Main Boulevard")
        ),
        LiveCamera(
            id = "pk_karachi_clifton",
            title = "Clifton Sea View & Do Darya Road",
            city = "Karachi",
            countryId = "pakistan",
            countryName = "Pakistan",
            flag = "🇵🇰",
            youtubeVideoId = "pG8N2k_qwe4",
            locationDescription = "Abdul Sattar Edhi Avenue & Coastal Belt",
            cameraType = "Coastal Highway",
            viewersCount = "3.4K",
            trafficStatus = "Active Traffic",
            tags = listOf("Karachi", "Clifton", "Sea View", "Do Darya")
        ),
        LiveCamera(
            id = "pk_isb_faisal",
            title = "Blue Area & Faisal Avenue Expressway",
            city = "Islamabad",
            countryId = "pakistan",
            countryName = "Pakistan",
            flag = "🇵🇰",
            youtubeVideoId = "iS2b_faisal_ave",
            locationDescription = "Jinnah Avenue Inter-junction & Faisal Ave Flyover",
            cameraType = "Expressway Cam",
            viewersCount = "1.8K",
            trafficStatus = "High-Speed Flow",
            tags = listOf("Islamabad", "Blue Area", "Faisal Avenue", "Expressway")
        ),
        LiveCamera(
            id = "pk_murree_mall",
            title = "Mall Road & Hill Station Expressway",
            city = "Murree",
            countryId = "pakistan",
            countryName = "Pakistan",
            flag = "🇵🇰",
            youtubeVideoId = "mR_mall_road",
            locationDescription = "Pindi Point & GPO Chowk Hill Road",
            cameraType = "Mountain Road Cam",
            viewersCount = "2.2K",
            trafficStatus = "Scenic Transit",
            tags = listOf("Murree", "Hill Station", "Mall Road", "Mountains")
        ),
        LiveCamera(
            id = "pk_rwp_murree_rd",
            title = "Murree Road & Saddar Metro Corridor",
            city = "Rawalpindi",
            countryId = "pakistan",
            countryName = "Pakistan",
            flag = "🇵🇰",
            youtubeVideoId = "rwp_metro_cam",
            locationDescription = "Benazir Bhutto Hospital / Chandni Chowk Flyover",
            cameraType = "Arterial Flyover",
            viewersCount = "1.6K",
            trafficStatus = "Busy Flyover",
            tags = listOf("Rawalpindi", "Murree Road", "Chandni Chowk", "Metro")
        ),

        // ==================== GERMANY ====================
        LiveCamera(
            id = "de_berlin_brandenburg",
            title = "Brandenburg Gate & Unter den Linden",
            city = "Berlin",
            countryId = "germany",
            countryName = "Germany",
            flag = "🇩🇪",
            youtubeVideoId = "8Bq8aD9-0G0",
            locationDescription = "Pariser Platz & Strasse des 17. Juni Corridor",
            cameraType = "Historic Boulevard",
            viewersCount = "4.5K",
            trafficStatus = "Regulated Zone",
            tags = listOf("Berlin", "Unter den Linden", "Mitte", "Historic")
        ),
        LiveCamera(
            id = "de_munich_stachus",
            title = "Karlsplatz (Stachus) & Sonnenstraße Ring",
            city = "Munich",
            countryId = "germany",
            countryName = "Germany",
            flag = "🇩🇪",
            youtubeVideoId = "munich_stachus_live",
            locationDescription = "Altstadt-Lehel Ring Road & Karlstor Square",
            cameraType = "City Ring Cam",
            viewersCount = "1.8K",
            trafficStatus = "Tram & Road Flow",
            tags = listOf("Bavaria", "Munich", "Stachus", "Karlsplatz")
        ),
        LiveCamera(
            id = "de_hamburg_port",
            title = "St. Pauli Landungsbrücken & Port Roads",
            city = "Hamburg",
            countryId = "germany",
            countryName = "Germany",
            flag = "🇩🇪",
            youtubeVideoId = "hamburg_port_live",
            locationDescription = "Bei den St. Pauli-Landungsbrücken Riverbank Road",
            cameraType = "Harbor / Road Cam",
            viewersCount = "2.9K",
            trafficStatus = "Smooth Flow",
            tags = listOf("Hamburg", "Elbe", "Landungsbrücken", "Harbor")
        ),
        LiveCamera(
            id = "de_frankfurt_skyline",
            title = "Main River Bridges & Financial District",
            city = "Frankfurt",
            countryId = "germany",
            countryName = "Germany",
            flag = "🇩🇪",
            youtubeVideoId = "frankfurt_skyline_cam",
            locationDescription = "Untermainbrücke & Mainkai Riverside Avenue",
            cameraType = "Bridge / Riverway",
            viewersCount = "2.1K",
            trafficStatus = "Moderate Flow",
            tags = listOf("Frankfurt", "Mainkai", "River Bridge", "Financial District")
        ),
        LiveCamera(
            id = "de_cologne_rhine",
            title = "Hohenzollern Bridge Approach & Domplatte",
            city = "Cologne",
            countryId = "germany",
            countryName = "Germany",
            flag = "🇩🇪",
            youtubeVideoId = "cologne_rhine_traffic",
            locationDescription = "Konrad-Adenauer-Ufer & Rhine Crossing",
            cameraType = "Riverfront Arterial",
            viewersCount = "1.7K",
            trafficStatus = "Active Flow",
            tags = listOf("Cologne", "Rhine", "Dom", "Hohenzollern")
        ),

        // ==================== CANADA ====================
        LiveCamera(
            id = "ca_toronto_dundas",
            title = "Yonge-Dundas Square & Yonge Street",
            city = "Toronto",
            countryId = "canada",
            countryName = "Canada",
            flag = "🇨🇦",
            youtubeVideoId = "toronto_dundas_live",
            locationDescription = "Yonge St & Dundas St East Intersection",
            cameraType = "Downtown Scramble",
            viewersCount = "5.1K",
            trafficStatus = "Heavy Transit",
            tags = listOf("Toronto", "Yonge St", "Dundas Square", "Ontario")
        ),
        LiveCamera(
            id = "ca_vancouver_robson",
            title = "Robson Street & Georgia Viaduct Corridor",
            city = "Vancouver",
            countryId = "canada",
            countryName = "Canada",
            flag = "🇨🇦",
            youtubeVideoId = "vancouver_robson_cam",
            locationDescription = "Robson & Burrard Street Downtown Core",
            cameraType = "Urban Arterial",
            viewersCount = "2.4K",
            trafficStatus = "Moderate Flow",
            tags = listOf("Vancouver", "BC", "Robson", "Pacific Rim")
        ),
        LiveCamera(
            id = "ca_montreal_sainte_catherine",
            title = "Rue Sainte-Catherine & Place des Festivals",
            city = "Montreal",
            countryId = "canada",
            countryName = "Canada",
            flag = "🇨🇦",
            youtubeVideoId = "montreal_downtown_cam",
            locationDescription = "Quartier des Spectacles Arterial Avenue",
            cameraType = "Cultural Boulevard",
            viewersCount = "1.6K",
            trafficStatus = "Pedestrian & Traffic",
            tags = listOf("Montreal", "Quebec", "Sainte-Catherine", "Downtown")
        ),
        LiveCamera(
            id = "ca_banff_avenue",
            title = "Banff Avenue & Rocky Mountain Parkway",
            city = "Banff",
            countryId = "canada",
            countryName = "Canada",
            flag = "🇨🇦",
            youtubeVideoId = "banff_avenue_live",
            locationDescription = "Trans-Canada Highway Access & Banff Ave",
            cameraType = "Alpine Highway",
            viewersCount = "3.8K",
            trafficStatus = "Scenic Flow",
            tags = listOf("Alberta", "Rockies", "Banff", "Trans-Canada")
        ),
        LiveCamera(
            id = "ca_niagara_parkway",
            title = "Niagara River Parkway & Clifton Hill",
            city = "Niagara Falls",
            countryId = "canada",
            countryName = "Canada",
            flag = "🇨🇦",
            youtubeVideoId = "niagara_falls_road_live",
            locationDescription = "Niagara Parkway & Fallsview Boulevard",
            cameraType = "Parkway Cam",
            viewersCount = "4.2K",
            trafficStatus = "Tourist Traffic",
            tags = listOf("Ontario", "Niagara", "Fallsview", "Parkway")
        )
    )

    fun getCamerasForCountry(countryId: String): List<LiveCamera> {
        return allCameras.filter { it.countryId.equals(countryId, ignoreCase = true) }
    }

    fun searchCameras(query: String, countryFilter: String? = null): List<LiveCamera> {
        val trimmed = query.trim().lowercase()
        val baseList = if (countryFilter != null) {
            allCameras.filter { it.countryId.equals(countryFilter, ignoreCase = true) }
        } else {
            allCameras
        }

        if (trimmed.isEmpty()) return baseList

        return baseList.filter { cam ->
            cam.title.lowercase().contains(trimmed) ||
            cam.city.lowercase().contains(trimmed) ||
            cam.countryName.lowercase().contains(trimmed) ||
            cam.locationDescription.lowercase().contains(trimmed) ||
            cam.tags.any { it.lowercase().contains(trimmed) }
        }
    }
}
