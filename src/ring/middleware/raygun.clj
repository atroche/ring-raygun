(ns ring.middleware.raygun
  (:import [com.mindscapehq.raygun4java.core RaygunClient]))

(defn raygun-params
  [request]
  (select-keys
    request
    [:server-port
     :server-name
     :remote-addr
     :uri
     :query-string
     :scheme
     :request-method
     :headers]))

(defn wrap-raygun-handler
  [handler api-key]
  (fn [request]
    (if api-key
      (try
        (handler request)
        (catch Exception e
          (do
            (.Send (RaygunClient. api-key) e [] (raygun-params request) )
            (throw e))))
      (handler request))))

