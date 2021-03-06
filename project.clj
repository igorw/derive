(defproject com.vitalreactor/derive "0.2.0-SNAPSHOT"
  :description "Clojurescript library to support efficient computation of up to date values derived from a mutable data source.  Designed to integrate with functional UI frameworks like Om and with data stores like Datascript and NativeStore"
  :url "http://github.com/vitalreactor/derive"
  :license {:name "MIT License"
            :url "http://github.com/vitalreactor/derive/blob/master/LICENSE"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2356"]
                 [prismatic/schema "0.2.6"]]
  :plugins [[lein-cljsbuild "1.0.3"]
            [com.cemerick/clojurescript.test "0.3.1"]]
  :hooks [leiningen.cljsbuild]
  :profiles
  {:test {:dependencies [[com.cemerick/clojurescript.test "0.3.1"]]
          :cljsbuild
          {:builds
           [ {:id "test"
              :source-paths ["src" "test"]
              :compiler {:output-to "target/test/testable.js"
                         :output-dir "target/test"
                         :optimizations :whitespace
                         :pretty-print true
                         :preamble ["phantomjs-shims.js"]}
              :notify-command ["phantomjs" :cljs.test/runner "target/test/testable.js"]}]
           :test-commands {"all" ["phantomjs" :runner
                                  "target/test/testable.js"]}}}})

