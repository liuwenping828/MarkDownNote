###  EasyPermissions 
https://github.com/googlesamples/easypermissions
1. build.gradle 添加
```
dependencies {
    compile 'pub.devrel:easypermissions:1.0.0'
}
```
2. Activity or Fragment 中重写 onRequestPermissionsResult 方法
```
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }    
```
3. 请求权限的方法
```
    // RC_CAMERA_PERM  请求码
    @AfterPermissionGranted(RC_CAMERA_PERM)
    public void cameraTask() {
        // hasPermission 方法重载可以多个权限
        if (EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA)) {
            // Have permission, do the thing!
            Toast.makeText(this, "TODO: Camera things", Toast.LENGTH_LONG).show();
        } else {
            // Ask for one permission
            // getString(R.string.rationale_camera) 阐述应用中使用该权限用来做什么，
            // 当用户拒绝系统弹出请求权限的对话框后，显示一个Dialog 来阐述应用中使用该权限用来做什么，
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_camera),
                    RC_CAMERA_PERM, Manifest.permission.CAMERA);
        }
    }
```
4. Activity or Fragment 中实现 EasyPermissions.PermissionCallbacks 接口
```
    // 授权通过
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Log.d(TAG, "onPermissionsGranted:" + requestCode + ":" + perms.size());
    }
    
    // 拒绝授权
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.d(TAG, "onPermissionsDenied:" + requestCode + ":" + perms.size());

        // (Optional) Check whether the user denied any permissions and checked "NEVER ASK AGAIN."
        // This will display a dialog directing them to enable the permission in app settings.
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            // 进入应用信息的设置
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         // 应用信息的设置后返回结果回调
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            // Do something after user returned from app settings screen, like showing a Toast.
            Toast.makeText(this, R.string.returned_from_app_settings_to_activity, Toast.LENGTH_SHORT).show();
        }
    }
```


     








