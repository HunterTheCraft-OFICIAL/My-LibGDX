
-verbose

# ignore external lib classes 
-keep class !com.mygdx.game.**,** { *; }

# keep enums
-keepclassmembers class * extends java.lang.Enum {
    <fields>;
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# example to ignore classes or packages
#-keep class com.mygdx.game.screen.MainScreen { *; }
#-keep class com.mygdx.game.api.dto.** { *; }
