# ring-raygun

Clojure Ring middleware to send uncaught exceptions to the [Raygun](http://raygun.io) exception monitoring service.

## Installation

Add the dependency to your project.clj:

```
[thegreatape/ring-raygun "0.1.0"]
```

## Usage

Add `wrap-raygun-handler` to your Ring middleware stack and pass it your Raygun API key:

```clojure
(require '[ring.middleware.raygun :refer [wrap-raygun-handler]])

(def app (-> routes
             ; ...
             (wrap-raygun-handler (System/getenv "RAYGUN_APIKEY"))))
```

Development environment note: if `wrap-raygun-handler` is passed a falsey value, it'll bypass the handler—useful for development environments where you don't want
to involve Raygun.


## License

Copyright © 2015 Thomas Mayfield

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
