/**
 * Created by vsrut on 28-01-2016.
 */

module.exports = function(grunt){
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        cssmin: {
            css: {
                files: {
                    'dist/min/app.style.min.css':['css/style.css']
                }
            }
        },
        autoprefixer: {
            options: {
                browsers: ['last 3 version','ie 8','ie 9']
            },
            files: {
                src: 'dist/min/app.style.min.css',
                dest: 'dist/min/app.style.min.css'
            }
        },
        uglify: {
            js: {
                files: {
                    'dist/min/app.script.min.js': ['js/angular.js','js/angular-ui-router.js','js/jquery-1.12.0.js',
                        'js/bootstrap.js','app/app.js','app/controllers/**/*.controller.js','app/js/**/*.min.js',
                        'app/services/**/*.service.js','js/angular-mocks.js']
                }
            }
        },
        watch:{
            css:{
                files: ['css/styles.css'],
                tasks: ['cssmin','autoprefixer']
            },
            js: {
                files: ['app/**/*.js','js/**/*.js'],
                tasks: ['uglify']
            }
        },
        karma:{
            unit: {
                options: {
                    frameworks: ['jasmine'],
                    browsers: ['PhantomJS'],
                    singleRun: true,
                    files: [
                        'js/angular.js','js/angular-ui-router.js','js/jquery-1.12.0.js','js/bootstrap.js','js/angular-mocks.js',
                        'app/**/*.js',
                        'tests/**/*.js'
                    ]
                }
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-karma');
    grunt.loadNpmTasks('grunt-autoprefixer');

    grunt.registerTask('default', ['cssmin','autoprefixer','uglify']);
};
