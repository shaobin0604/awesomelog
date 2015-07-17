# Awesome Log

Awesome Log provides a lean wrapper around the default logging utility built into Android.

Your log statement is prefaced by `[ thread name: file name: line number: method name ] --> `.

## Usage

    import io.github.shaobin0604.awesomelog.Log;

    Log.v("Logging a verbose message...");

Will output something like this in logcat:

    D/AwesomeLog﹕ [ main: MainActivity.java: 17: onCreate ] --> Logging a verbose message...

Each of the verbosity levels from the default Log apply here:

- `Log.v(...)`
- `Log.d(...)`
- `Log.i(...)`
- `Log.w(...)`
- `Log.e(...)`


### Set log level

    Log.setLevel(android.util.Log.VERBOSE); // should be one of VERBOSE/DEBUG/INFO/WARN/ERROR

### Set log tag

    Log.setTag("{The global Log TAG}")

# License

    Copyright 2014 Bin Shao

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.