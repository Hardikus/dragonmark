(defproject dragonmark "0.1.0-SNAPSHOT"
  :description "Distributed CSP/core.async"
  :url "http://dragonmark.org"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2268"]
                 [org.clojure/core.async "0.1.303.0-886421-alpha"]]

  :plugins [[codox "0.8.10"]
            [lein-cljsbuild "1.0.3"]
            [com.keminglabs/cljx "0.4.0"]
            [com.cemerick/clojurescript.test "0.3.1"]]


  :jar-exclusions [#"\.cljx|\.swp|\.swo|\.DS_Store"]

  :cljx
  {:builds
   [{:source-paths ["src"], :output-path "target/generated/src", :rules :clj}
    {:source-paths ["test"], :output-path "target/generated/test", :rules :clj}
    {:source-paths ["src"], :output-path "target/generated/src", :rules :cljs}
    {:source-paths ["test"], :output-path "target/generated/test", :rules :cljs}]}
  :source-paths ["src" "target/generated/src"]
  :test-paths   ["test" "target/generated/test"]
  :hooks [cljx.hooks]
  :cljsbuild
  {:builds
   [{:source-paths ["target/generated/src" "target/generated/test"]
     :compiler {:output-to "target/main.js"}}]
   :test-commands {"unit-tests" ["phantomjs" :runner "target/main.js"]}}
  :aliases
  {"test-cljs" ["do" ["cljx" "once"] ["cljsbuild" "test"]]
   "test-all"  ["do" ["test"] ["cljsbuild" "test"]]}
  :profiles
  {:provided {:dependencies [[org.clojure/clojurescript "0.0-2268"]]}}

)
